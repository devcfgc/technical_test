resource "azurerm_lb" "public" {
  name                = "${var.name}-plb"
  location            = "${var.location}"
  resource_group_name = "${var.resource_group_name}"

  frontend_ip_configuration {
    name                 = "${var.primary_frontend_configuration_name}"
    public_ip_address_id = "${azurerm_public_ip.primary.id}"
  }

  tags {
    CostCenter = "${var.cost_center}"
    Product    = "${var.product}"
    Team       = "${var.team}"
  }
}
