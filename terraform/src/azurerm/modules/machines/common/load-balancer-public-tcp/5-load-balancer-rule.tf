resource "azurerm_lb_rule" "rule" {
  name                           = "${var.name}-rule"
  location                       = "${var.location}"
  resource_group_name            = "${var.resource_group_name}"
  loadbalancer_id                = "${azurerm_lb.public.id}"
  protocol                       = "${azurerm_lb_probe.tcp.protocol}"
  frontend_port                  = "${var.port}"
  backend_port                   = "${var.port}"
  frontend_ip_configuration_name = "${var.primary_frontend_configuration_name}"
  load_distribution              = "Default"
  idle_timeout_in_minutes        = 4
  backend_address_pool_id        = "${azurerm_lb_backend_address_pool.internal.id}"
  probe_id                       = "${azurerm_lb_probe.tcp.id}"
}
