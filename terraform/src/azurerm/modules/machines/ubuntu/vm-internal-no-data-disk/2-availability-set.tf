resource "azurerm_availability_set" "machine" {
  name                = "${var.availability_set_name}"
  location            = "${var.location}"
  resource_group_name = "${module.base.resource_group_name}"

  tags {
    CostCenter = "${var.cost_center}"
    Product    = "${var.product}"
    Team       = "${var.team}"
  }
}
