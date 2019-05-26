import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CustomerdashboardComponent } from './customerdashboard.component';
import { BrowserModule, By } from '@angular/platform-browser';
import { CustomerVehiclesManagerService } from '../shared/services/customervehiclesmanagerservice.service';
import { UserServiceMock } from '../../mocks/user.service.mock';


describe('CustomerdashboardComponent', () => {
    let component: CustomerdashboardComponent;
    let fixture: ComponentFixture<CustomerdashboardComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [CustomerdashboardComponent],
            providers: [
                { provide: CustomerVehiclesManagerService, useClass: UserServiceMock }
            ]
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(CustomerdashboardComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
