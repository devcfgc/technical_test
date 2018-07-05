resource "azurerm_public_ip" "primary" {
  name                         = "${var.name}-ip"
  location                     = "${var.location}"
  resource_group_name          = "${var.resource_group_name}"
  public_ip_address_allocation = "Static"
  idle_timeout_in_minutes      = 4
  domain_name_label            = "${var.name}"
}
