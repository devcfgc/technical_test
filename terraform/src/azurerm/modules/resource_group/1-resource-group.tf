resource "azurerm_resource_group" "primary" {
  name     = "${var.name}"
  location = "${var.location}"

  tags {
    CostCenter = "${var.cost_center}"
    Product    = "${var.product}"
    Team       = "${var.team}"
  }
}
