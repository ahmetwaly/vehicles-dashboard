import { Component, OnInit , OnDestroy } from '@angular/core';
import { Customer } from '../shared/dto/Customer';
import { CustomerVehiclesManagerService } from '../shared/services/customervehiclesmanagerservice.service';
import {Observable, interval} from 'rxjs';
import { environment } from '../../environments/environment';

@Component({
    selector: 'app-customerdashboard',
    templateUrl: './customerdashboard.component.html',
    styleUrls: ['./customerdashboard.component.css'],
})
export class CustomerdashboardComponent implements OnInit {

    customers: Customer[] = [];
    statutList = ['All', 'CONNECTED', 'DISCONNECTED'];
    selectedVehicleStatus: string = "All";

    timerSubscribtion: any ;
    constructor(private customerVehicleManager: CustomerVehiclesManagerService) { }
    filteredName: string;
    ngOnInit() {
       this.timerSubscribtion =interval(environment.refreshInterval).subscribe(() => {
            this.customerVehicleManager.getCustomerVehicles()
                .subscribe((customersList: Customer[]) => { this.customers = customersList; });
        });
    }

    ngOnDestroy(){
        if(this.timerSubscribtion){
            this.timerSubscribtion.unsubscribe();
        }

    }

}
