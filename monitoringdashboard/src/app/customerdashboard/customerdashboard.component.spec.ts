import { async, ComponentFixture, TestBed} from '@angular/core/testing';
import { CustomerdashboardComponent } from './customerdashboard.component';
import { CustomerVehiclesManagerService } from '../shared/services/customervehiclesmanagerservice.service';
import { CustomerVehiclesManagerServiceMock } from '../shared/mocks/customervehiclesmanagerservice.service.mock';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { CustomerNameFilterPipe } from '../shared/pipes/customersfilter.pipe';
import { VehicleStatusFilterPipe } from '../shared/pipes/vehiclefiliter.pipe';

describe('CustomerdashboardComponent', () => {
    let component: CustomerdashboardComponent;
    let fixture: ComponentFixture<CustomerdashboardComponent>;
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [
                BrowserModule,
                AppRoutingModule,
                FormsModule,
                CommonModule,
                HttpClientModule
            ],
            declarations: [
                CustomerdashboardComponent,
                CustomerNameFilterPipe,
                VehicleStatusFilterPipe,
            ],
            providers: [{ provide: CustomerVehiclesManagerService, useClass: CustomerVehiclesManagerServiceMock }]
        })
            .compileComponents();
    }));

    beforeEach(async(() => {
        fixture = TestBed.createComponent(CustomerdashboardComponent);
        component = fixture.componentInstance;
    }));

    it('should create', () => {
        expect(component).toBeTruthy();
    });

    it('verify number of customers and vehciles', async(() => {
        component.ngOnInit()
        expect(component.customers.length).toEqual(3);
        expect(component.customers[0].vehicles.length).toEqual(3);
        component.ngOnDestroy();
    }));
    it('should vehicle status filter', async(() => {
        component.ngOnInit()
        fixture.detectChanges();
        const compiled = fixture.debugElement.nativeElement;
        console.log(compiled.name)
        expect(compiled.querySelectorAll('#customerNameDev').length).toEqual(3)
        component.ngOnDestroy();
    }));

    afterEach(() => {
        fixture.destroy();
        component = null;
    });
});
