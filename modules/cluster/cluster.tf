resource "azurerm_resource_group" "k8s" {
    name = var.resourcename
    location = var.location
}

resource "azurerm_kubernetes_cluster" "k8s" {
    name =                  var.clustername
    location =              azurerm_resource_group.k8s.location
    resource_group_name =   azurerm_resource_group.k8s.name
    dns_prefix =            var.dnspreffix

    default_node_pool {
    name = "default"
    node_count = var.agentnode
    vm_size = var.size
    }

    service_principal {
        client_id = var.sp_client_id
        client_secret = var.sp_client_secret
    }
}