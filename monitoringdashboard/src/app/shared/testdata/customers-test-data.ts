import { Customer } from  '../dto/Customer';

export const CUSTOMERS_DATA: Customer[] = [
  {
    id: 1,
    name: 'Kalles Grustransporter AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: [
      {
        vehicleId: 'YS2R4X20005399401',
        regNumber: 'ABC123',
        status: 'CONNECTED'
      },
      {
        vehicleId: 'VLUR4X20009093588',
        regNumber: 'DEF456',
        status: 'DISCONNECTED'
      },
      {
        vehicleId: 'VLUR4X20009048066',
        regNumber: 'GHI789',
        status: 'DISCONNECTED'
      }
    ]
  },
  {
    id: 2,
    name: 'Johans Bulk AB',
    address: 'Cementvägen 8, 111 11 Södertälje',
    vehicles: [
      {
        vehicleId: 'YS2R4X20005388011',
        regNumber: 'JKL012',
        status: 'DISCONNECTED'
      },
      {
        vehicleId: 'YS2R4X20005387949',
        regNumber: 'MNO345',
        status: 'CONNECTED'
      }
    ]
  },
  {
    id: 3,
    name: 'Haralds Värdetransporter AB',
    address: 'Budgetvägen 1, 333 33 Uppsala',
    vehicles: [
      {
        vehicleId: 'VLUR4X20009048067',
        regNumber: 'PQR678',
        status: 'CONNECTED'
      },
      {
        vehicleId: 'YS2R4X20005387055',
        regNumber: 'STU901',
        status: 'CONNECTED'
      }
    ]
  }
];