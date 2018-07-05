resource "azurerm_resource_group" "state" {
  name     = "terraform-state"
  location = "North Europe"

  tags {
    CostCenter = "Infrastructure"
    Product    = "Terraform"
    Team       = "devcfgc"
  }
}

resource "azurerm_storage_account" "state" {
  name                = "terraformstate"
  resource_group_name = "${azurerm_resource_group.state.name}"
  location            = "${azurerm_resource_group.state.location}"
  account_type        = "Standard_GRS"

  tags {
    CostCenter = "Infrastructure"
    Product    = "Terraform"
    Team       = "devcfgc"
  }
}

resource "azurerm_storage_container" "devcfgc" {
  name                  = "terraform-devcfgc"
  resource_group_name   = "${azurerm_resource_group.state.name}"
  storage_account_name  = "${azurerm_storage_account.state.name}"
  container_access_type = "private"
}
