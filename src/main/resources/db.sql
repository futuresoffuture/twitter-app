aws dynamodb create-table --cli-input-json file://create-table-tweet.json --endpoint-url http://localhost:8000

aws dynamodb create-table --cli-input-json file://create-table-user.json --endpoint-url http://localhost:8000

aws dynamodb list-tables --endpoint-url http://localhost:8000

aws dynamodb describe-table --table-name tweet --endpoint-url http://localhost:8000

