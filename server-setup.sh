sudo apt-get install -y python-software-properties mosh jdk-6-jre-headless unzip git openjdk-6-jdk
wget http://downloads.typesafe.com/play/2.1.1/play-2.1.1.zip
unzip play-2.1.1.zip
git clone git@github.com:tmarthal/vector_health.git
cd ~/vector_health/
sudo ~/play-2.1.1/play -DapplyEvolutions.default=true "start 80"
