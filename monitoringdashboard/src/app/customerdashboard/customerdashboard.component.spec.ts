import { async, ComponentFixture, TestBed, fakeAsync, tick, flushMicrotasks } from '@angular/core/testing';
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
    // it('should render title in a h1 tag', async(() => {
    //     const fixture = TestBed.createComponent(AppComponent);
    //     fixture.detectChanges();
    //     const compiled = fixture.debugElement.nativeElement;
    //     expect(compiled.querySelector('h1').textContent).toContain('Welcome to Angular Unit Testing!');
    // }));

    afterEach(() => {
        fixture.destroy();
        component = null;
    });
});
