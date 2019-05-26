import { TestBed } from '@angular/core/testing';

import { CustomerVehiclesManagerService } from './customervehiclesmanagerservice.service';
import { HttpClientModule } from '@angular/common/http'; 

describe('CustomervehiclesmanagerserviceService', () => {

    beforeEach(() => TestBed.configureTestingModule({
        imports:[HttpClientModule],
        providers: [CustomerVehiclesManagerService]
    }));

    it('should be created', () => {
        const service: CustomerVehiclesManagerService = TestBed.get(CustomerVehiclesManagerService);
        expect(service).toBeTruthy();
    });
});
