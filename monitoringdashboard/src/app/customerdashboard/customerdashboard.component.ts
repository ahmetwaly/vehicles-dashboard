import { Component, OnInit } from '@angular/core';
import { Customer } from '../shared/dto/Customer';
import { CustomerVehiclesManagerService } from '../shared/services/customervehiclesmanagerservice.service';
@Component({
    selector: 'app-customerdashboard',
    templateUrl: './customerdashboard.component.html',
    styleUrls: ['./customerdashboard.component.css'],
})
export class CustomerdashboardComponent implements OnInit {

    customers: Customer[] = [];
    statutList = ['All', 'CONNECTED', 'DISCONNECTED'];
    selectedVehicleStatus: string = "All";
    constructor(private customerVehicleManager: CustomerVehiclesManagerService) { }
    filteredName: string;
    ngOnInit() {
        this.customerVehicleManager.getCustomerVehicles()
            .subscribe((customersList: Customer[]) => { this.customers = customersList ; });
    }

}
