import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { CustomerNameFilterPipe } from './shared/pipes/customersfilter.pipe';
import { VehicleStatusFilterPipe } from './shared/pipes/vehiclefiliter.pipe';
import {CustomerVehiclesManagerService} from './shared/services/customervehiclesmanagerservice.service';

import { HttpClientModule } from '@angular/common/http'; 

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        CustomerdashboardComponent,
        CustomerNameFilterPipe,
        VehicleStatusFilterPipe
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        CommonModule,
        HttpClientModule

    ],
    providers: [CustomerVehiclesManagerService],
    bootstrap: [AppComponent]
})
export class AppModule { }
