import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CustomerdashboardComponent } from './customerdashboard.component';
import { Customer } from '../shared/dto/Customer';
import { CustomerVehiclesManagerService } from '../shared/services/customervehiclesmanagerservice.service';
import {Observable, interval} from 'rxjs';
import { environment } from '../../environments/environment';


describe('CustomerdashboardComponent', () => {
  let component: CustomerdashboardComponent;
  let fixture: ComponentFixture<CustomerdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerdashboardComponent ]
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
