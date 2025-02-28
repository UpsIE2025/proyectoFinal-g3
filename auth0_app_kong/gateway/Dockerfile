FROM kong:latest
COPY kong.yml /usr/local/kong/declarative/kong.yml
CMD ["kong", "start", "--conf", "/usr/local/kong/kong.conf"]