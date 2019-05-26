import { Injectable } from '@angular/core';
import { of, Observable } from 'rxjs';
import { Customer } from '../dto/Customer';

import { CUSTOMERS_DATA }from "../testdata/customers-test-data";

@Injectable()
export class CustomerVehiclesManagerServiceMock {
    getCustomerVehicles(): Observable<Customer[]> {
        console.log('moc called')
        return of(CUSTOMERS_DATA);
    }

}
