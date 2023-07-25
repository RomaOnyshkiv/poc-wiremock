Before start run wiremock in docker

```agsl
docker run -it --rm  -p 8080:8080 --name wiremock -v $PWD:/home/wiremock wiremock/wiremock:2.35.0
```