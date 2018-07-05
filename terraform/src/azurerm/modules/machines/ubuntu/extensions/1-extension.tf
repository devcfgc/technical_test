resource "azurerm_virtual_machine_extension" "combined" {
  name                 = "combined"
  location             = "${var.location}"
  resource_group_name  = "${var.resource_group_name}"
  virtual_machine_name = "${var.virtual_machine_name}"
  publisher            = "Microsoft.Azure.Extensions"
  type                 = "CustomScript"
  type_handler_version = "2.0"

  settings = <<SETTINGS
  {
    "commandToExecute": "sh ubuntu-puppet3.sh ${var.puppet_host} ${var.puppet_environment} ${var.virtual_machine_name} ${var.data_center}.node.veinternal.com",
    "fileUris": [
      "https://gist.githubusercontent.com/tombuildsstuff/8b8b98e0329cc10a2ee230bc0f663894/raw/b624b4e260fcb26ebfb75a9d1af8fbef0a338a20/ubuntu-puppet3.sh"
    ]
  }
SETTINGS
}
