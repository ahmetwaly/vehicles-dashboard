import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../dto/Customer';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { environment } from '../../../environments/environment';



@Injectable()
export class CustomerVehiclesManagerService {

    customervehicleManagerUrl: string = environment.baseUrl;

    constructor(private httpClient: HttpClient) { }


    getCustomerVehicles(): Observable<Customer[]>{
        return this.httpClient.get<Customer[]>(this.customervehicleManagerUrl)
            .pipe(
                catchError(this.handleError)
            );

    }

    private handleError(error : any) {
    console.error('server error:', error);
    if (error.error instanceof Error) {
        const errMessage = error.error.message;
        return Observable.throw(errMessage);
    }
    return Observable.throw(error || 'backend server error');
}
}
