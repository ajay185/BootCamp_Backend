provider "azurerm" {
    subscription_id=var.sp_subscription_id
    client_id = var.sp_client_id
    client_secret = var.sp_client_secret
    tenant_id = var.sp_tenant_id
    
    features{}
}
module "cluster" {
    source = "./modules/cluster/"
    sp_client_id = var.sp_client_id
    sp_client_secret = var.sp_client_secret
}

module "k8ss" {
    source =                            "./modules/k8s/"
    host =                              "${module.cluster.host}"
    cluster_ca_certificate =            "${base64decode(module.cluster.cluster_ca_certificate)}"
    client_key =                        "${base64decode(module.cluster.client_key)}"
    client_certificate =                "${base64decode(module.cluster.client_certificate)}"
}
