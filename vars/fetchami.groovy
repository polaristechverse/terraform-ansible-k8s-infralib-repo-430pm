def call(String region) {
    sh """
    AMIID=\$(aws ec2 describe-images --region ${region} --owners self --query 'Images | sort_by(@, &CreationDate)[-1].ImageId' --output text)
    echo "Extracted AMI: \$AMIID"
    sed -i "s/^ami *= *.*/ami = \\"\$AMIID\\"/" terraform.tfvars
    echo "Updated terraform.tfvars:"
    cat terraform.tfvars
    """
}