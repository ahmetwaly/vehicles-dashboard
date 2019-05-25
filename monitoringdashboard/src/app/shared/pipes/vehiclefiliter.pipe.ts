import { Pipe, PipeTransform } from '@angular/core';
import { Vehicle } from '../dto/Vehicle';

@Pipe({
    name: 'vehiclesfiliter',
    pure: false
})
export class VehicleStatusFilterPipe implements PipeTransform {
    transform(vehicles: Vehicle[], selectedVehicleStatus: string): any {
        console.log(selectedVehicleStatus);
        if (!selectedVehicleStatus ||selectedVehicleStatus.toLocaleLowerCase()==="all") { return vehicles; }
        return vehicles.filter((vehicle: Vehicle) => {
            return vehicle.status.toLowerCase() === selectedVehicleStatus.toLocaleLowerCase();
        });
    }
}
