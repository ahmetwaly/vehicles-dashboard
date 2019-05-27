
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
      AKS_CLUSTER=vehicles-cluster
      DNS_NAME=monitordashboard
      
   - Create a resource group for AKS
      ```bash
       az group create --name $AKS_RESOURCE_GROUP --location eastus
   - Create  Azure container registery ACR and keep copy of result for future use
      ```bash
         az acr create --resource-group $AKS_RESOURCE_GROUP --name $ACR_REGISTRY --sku Standard
         ACR_REGISTRY_ID=$(az acr show --name $ACR_REGISTRY --query id --output tsv)
   - Create service principal for ACR access
       ```bash
       SP_PASSWD =$(az ad sp create-for-rbac --name $ACR_SP_NAME --scopes $ACR_REGISTRY_ID \
       --role="Contributor" --query     password --output tsv)
       SP_APP_ID=$(az ad sp show --id $ACR_SP_NAME --query appId --output tsv)
       
   - Create AKS cluster 
      ```bash 
      az aks create --resource-group $AKS_RESOURCE_GROUP --name $AKS_CLUSTER \
      --service-principal $SP_APP_ID --client-secret $SP_PASSWD --node-count 1 --generate-ssh-keys
      
   - Create public ip address and dns name
     ````bash
       az network public-ip create -g vehicles-dashboard -n monitordashboardip --allocation-method Static --dns-name $DNS_NAME
      
   - install cli tools
      ```bash 
       az aks install-cli
  - Use Kubectl with the cluster  
    ```bash
       az aks get-credentials --resource-group $AKS_RESOURCE_GROUP --name $AKS_CLUSTER
  - create tiller service accounts 
      ```bash
       kubectl create serviceaccount tiller --namespace kube-system
       kubectl create clusterrolebinding tiller --clusterrole cluster-admin --serviceaccount=kube-system:tiller

  - Create k8 namespaces 
     ```bash
     kubectl create namespace backend
     kubectl create namespace frontend
     
  - install nginx ingress controller 
   ````bash 
       helm install stable/nginx-ingress --namespace kube-system -n nginx-ingress
