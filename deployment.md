
# Create Azure Container Register(ACR)
 - prerequistes 
   - Azure subscribtion
   - Azure CLI
 - steps
   - login to you azure subscribtion
      ```bash 
      Az login 
   - Create a resource group for AKS
      ```bash
       az group create --name vehicles-dashboard --location eastus
   - Create a Azure container registery ACR 
      ```bash
         az acr create --resource-group vehicles-dashboard --name vehiclesDashboardRegistry --sku Basic
   
