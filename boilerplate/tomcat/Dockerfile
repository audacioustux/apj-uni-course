From homebrew/brew:latest

RUN brew update
RUN brew install tomcat@10

WORKDIR /home/linuxbrew/.linuxbrew/opt/tomcat/libexec
ADD --chown=linuxbrew:linuxbrew conf/tomcat-users.xml conf/
ADD --chown=linuxbrew:linuxbrew webapps/manager/META-INF/context.xml webapps/manager/META-INF/

WORKDIR webapps

EXPOSE 8080

ENTRYPOINT ["catalina", "run"]
