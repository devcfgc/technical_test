# Ve's Terraform Managed Infrastructure

## Getting Started
You need the following dependencies:
 - [Terraform](https://www.terraform.io/downloads.html)


Download the Modules:
```
terraform get
```

Run Terraform:
```
terraform plan --var-file=../configuration/ci.tf
```

To validate that your code is valid - you can run the following command:
```
terraform validate
```

More details about each of these commands is available on the [Terraform Website](https://www.terraform.io/docs/commands/index.html)
