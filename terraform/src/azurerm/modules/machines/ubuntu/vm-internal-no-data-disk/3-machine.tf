resource "azurerm_virtual_machine" "machine" {
  name                  = "${var.name}"
  location              = "${var.location}"
  resource_group_name   = "${module.base.resource_group_name}"
  network_interface_ids = ["${module.base.network_interface_id}"]
  vm_size               = "${var.size}"
  availability_set_id   = "${azurerm_availability_set.machine.id}"

  storage_image_reference {
    publisher = "Canonical"
    offer     = "UbuntuServer"
    sku       = "14.04.5-LTS"
    version   = "latest"
  }

  storage_os_disk {
    name          = "osdisk"
    vhd_uri       = "${module.base.storage_account_primary_blob_endpoint}${module.base.storage_container_name}/osdisk.vhd"
    caching       = "ReadWrite"
    create_option = "FromImage"
    disk_size_gb  = 100
  }

  os_profile {
    computer_name  = "${var.name}"
    admin_username = "${var.admin_username}"
    admin_password = "${var.admin_password}"
  }

  os_profile_linux_config {
    disable_password_authentication = false
  }

  tags {
    AutoShutdownSchedule = "${var.auto_shutdown}"
    CostCenter           = "${var.cost_center}"
    Product              = "${var.product}"
    Team                 = "${var.team}"
  }
}
