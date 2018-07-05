output "network_interface_id" {
  value = "${azurerm_network_interface.internal.id}"
}

output "storage_container_name" {
  value = "${azurerm_storage_container.machine.name}"
}

output "storage_account_primary_blob_endpoint" {
  value = "${azurerm_storage_account.machine.primary_blob_endpoint}"
}

output "resource_group_name" {
  value = "${var.resource_group_name}"
}
