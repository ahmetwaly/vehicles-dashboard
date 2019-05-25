import { Pipe, PipeTransform } from '@angular/core';
import { Customer } from '../dto/Customer';

@Pipe({
    name: 'customersfilter',
    pure: false
})
export class CustomerNameFilterPipe implements PipeTransform {
    transform(customers: Customer[], customerName: string): any {
        if (!customerName) return customers;
        return customers.filter((cust: Customer) => {
            return cust.name.toLowerCase().indexOf(customerName.toLocaleLowerCase()) > -1;
        });
    }
}
