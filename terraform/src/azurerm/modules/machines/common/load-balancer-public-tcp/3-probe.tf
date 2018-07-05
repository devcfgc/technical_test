resource "azurerm_lb_probe" "tcp" {
  name                = "${var.name}-probe"
  location            = "${var.location}"
  resource_group_name = "${var.resource_group_name}"
  loadbalancer_id     = "${azurerm_lb.public.id}"
  port                = "${var.port}"
  protocol            = "Tcp"
  interval_in_seconds = 5
  number_of_probes    = 2
}
