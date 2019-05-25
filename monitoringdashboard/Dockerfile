### STAGE 1: Build ###

FROM node:8.11.1-alpine as builder

# Preparing working environment.
ARG buildEnv=development
RUN mkdir -p /usr/src/monitoringdashboard
WORKDIR /usr/src/monitoringdashboard

# Installing dependencies.
COPY package*.json /usr/src/monitoringdashboard/
RUN npm install

# Copy openhome-panel source into image.
COPY . /usr/src/monitoringdashboard

# Building app.
RUN npm run-script build -- --configuration ${buildEnv}

### STAGE 2: Setup ###

FROM nginx:1.13.12-alpine

# Removing nginx default page.
RUN rm -rf /usr/share/nginx/html/*

# Copying nginx configuration.
COPY /nginx/nginx.conf /etc/nginx/conf.d/default.conf

# Copying openhome-panel source into web server root.
COPY --from=builder /usr/src/monitoringdashboard/dist/monitoringdashboard /usr/share/nginx/html

# Exposing ports.
EXPOSE 80

# Starting server.
CMD ["nginx", "-g", "daemon off;"]
