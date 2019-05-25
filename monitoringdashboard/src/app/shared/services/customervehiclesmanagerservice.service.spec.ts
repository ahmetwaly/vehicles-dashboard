import { TestBed } from '@angular/core/testing';

import { CustomerVehiclesManagerService } from './customervehiclesmanagerservice.service';

describe('CustomervehiclesmanagerserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerVehiclesManagerService = TestBed.get(CustomerVehiclesManagerService);
    expect(service).toBeTruthy();
  });
});
