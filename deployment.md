
# Create Azure Container Register(ACR)
 - prerequistes 
   - Azure subscribtion
   - Azure CLI
 - steps
   - login to you azure subscribtion
      ```bash 
      Az login 
   - prepare variables 
     ```bahs 
      AKS_RESOURCE_GROUP=vehicles-dashboard
      ACR_REGISTRY=vehiclesDashboardRegistry
      ACR_SP_NAME=http://acr-vehicles-rbac
      
   - Create a resource group for AKS
      ```bash
       az group create --name $AKS_RESOURCE_GROUP --location eastus
   - Create  Azure container registery ACR and keep copy of result for future use
      ```bash
         az acr create --resource-group $AKS_RESOURCE_GROUP --name $ACR_REGISTRY --sku Basic
         ACR_REGISTRY_ID=$(az acr show --name $ACR_REGISTRY --query id --output tsv)
         
   - Create service princible for ACR access
    ```bash
       SP_PASSWD =$(az ad sp create-for-rbac --name $ACR_SP_NAME --scopes $ACR_REGISTRY_ID  --role="Contributor" --query password --output tsv)
       SP_APP_ID=$(az ad sp show --id $ACR_SP_NAME --query appId --output tsv)
    

  
       
