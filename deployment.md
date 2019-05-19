
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
   - Create  Azure container registery ACR and keep copy of result for future use
      ```bash
         az acr create --resource-group vehicles-dashboard --name vehiclesDashboardRegistry --sku Basic
   - Prepare var for use 
     ```bash
      ACR_REGISTRY_ID=$(az acr show --name $ACR_NAME --query id --output tsv)
      

   -Create service princible for ACR access
    ```bash
       SP_PASSWD =$(az ad sp create-for-rbac --name http://acr-vehicles-rbac --scopes $ACR_REGISTRY_ID  --role="Contributor" --query password --output tsv)
       SP_APP_ID=$(az ad sp show --id http://acr-vehicles-rbac --query appId --output tsv)

  
       
