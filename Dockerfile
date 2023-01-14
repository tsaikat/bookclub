FROM gradle:7-jdk-alpine
COPY . /app
WORKDIR /app
RUN gradle build

#CMD java -jar build/libs/bookclub-1.0-SNAPSHOT.jar
CMD gradle bootRun