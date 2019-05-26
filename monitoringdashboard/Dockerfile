FROM nginx:1.13.12-alpine

# Removing nginx default page.
RUN rm -rf /usr/share/nginx/html/*

# Copying nginx configuration.
COPY ./nginx/nginx.conf /etc/nginx/conf.d/default.conf

# Copying monitoringdashboard source into web server root.
COPY dist/monitoringdashboard/ /usr/share/nginx/html

# Exposing ports.
EXPOSE 80

# Starting server.
CMD ["nginx", "-g", "daemon off;"]
