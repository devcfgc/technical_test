resource "azurerm_network_interface" "internal" {
  name                = "${var.virtual_machine_name}-ni"
  location            = "${var.location}"
  resource_group_name = "${var.resource_group_name}"

  ip_configuration {
    name                                    = "internal"
    subnet_id                               = "${var.subnet_id}"
    private_ip_address_allocation           = "dynamic"
    load_balancer_backend_address_pools_ids = ["${var.backend_address_pool_ids}"]
  }

  tags {
    CostCenter = "${var.cost_center}"
    Product    = "${var.product}"
    Team       = "${var.team}"
  }
}
