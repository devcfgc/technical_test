resource "azurerm_lb_backend_address_pool" "internal" {
  name                = "internal"
  location            = "${var.location}"
  resource_group_name = "${var.resource_group_name}"
  loadbalancer_id     = "${azurerm_lb.public.id}"
}
