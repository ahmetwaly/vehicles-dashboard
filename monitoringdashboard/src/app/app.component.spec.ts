import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { CustomerNameFilterPipe } from './shared/pipes/customersfilter.pipe';
import { VehicleStatusFilterPipe } from './shared/pipes/vehiclefiliter.pipe';
import { CustomerVehiclesManagerService } from './shared/services/customervehiclesmanagerservice.service';
import { CustomerVehiclesManagerServiceMock } from './shared/mocks/customervehiclesmanagerservice.service.mock';
import { HttpClientModule } from '@angular/common/http';

describe('AppComponent', () => {
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [
                RouterTestingModule,
                BrowserModule,
                AppRoutingModule,
                FormsModule,
                CommonModule,
                HttpClientModule
            ],
            declarations: [
                AppComponent,
                HeaderComponent,
                FooterComponent,
                CustomerdashboardComponent,
                CustomerNameFilterPipe,
                VehicleStatusFilterPipe,
            ],
            providers: [CustomerVehiclesManagerService, CustomerVehiclesManagerServiceMock]
        }).compileComponents();
    }));

    it('should create the app', () => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.debugElement.componentInstance;
        expect(app).toBeTruthy();
    });

    it(`should have as title 'monitoringdashboard'`, () => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.debugElement.componentInstance;
        expect(app.title).toEqual('monitoringdashboard');
    });

});
