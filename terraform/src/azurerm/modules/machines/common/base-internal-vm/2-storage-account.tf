resource "azurerm_storage_account" "machine" {
  name                = "${var.storage_account_name}"
  resource_group_name = "${var.resource_group_name}"
  location            = "${var.location}"
  account_type        = "${var.storage_account_type}"

  tags {
    CostCenter = "${var.cost_center}"
    Product    = "${var.product}"
    Team       = "${var.team}"
  }
}

resource "azurerm_storage_container" "machine" {
  name                  = "${var.virtual_machine_name}"
  resource_group_name   = "${var.resource_group_name}"
  storage_account_name  = "${azurerm_storage_account.machine.name}"
  container_access_type = "private"
}
