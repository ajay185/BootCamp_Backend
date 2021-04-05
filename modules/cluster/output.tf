output "kube_config" { 
    value = azurerm_kubernetes_cluster.k8s.kube_config_raw
}
output "fqdn" {
    value = azurerm_kubernetes_cluster.k8s.fqdn
}
output "client_certificate" {
    value = azurerm_kubernetes_cluster.k8s.kube_config.0.client_certificate
}
output "cluster_ca_certificate" {
    value = azurerm_kubernetes_cluster.k8s.kube_config.0.cluster_ca_certificate
}
output "client_key" {
    value = azurerm_kubernetes_cluster.k8s.kube_config.0.client_key
}
output "host" {
    value = azurerm_kubernetes_cluster.k8s.kube_config.0.host
}