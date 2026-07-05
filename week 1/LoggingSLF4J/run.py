import os
import urllib.request
import subprocess
import sys

# Dependencies
JARS = {
    "slf4j-api-1.7.30.jar": "https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.30/slf4j-api-1.7.30.jar",
    "logback-classic-1.2.3.jar": "https://repo1.maven.org/maven2/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar",
    "logback-core-1.2.3.jar": "https://repo1.maven.org/maven2/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar"
}

def setup():
    if not os.path.exists("lib"):
        os.makedirs("lib")
    for filename, url in JARS.items():
        filepath = os.path.join("lib", filename)
        if not os.path.exists(filepath):
            print(f"Downloading {filename}...")
            urllib.request.urlretrieve(url, filepath)
        else:
            print(f"{filename} is ready")

def compile_and_run():
    if not os.path.exists("bin"):
        os.makedirs("bin")
    
    # Classpath separator (Windows uses ';', others use ':')
    cp_sep = ";" if os.name == "nt" else ":"
    
    # Gather jars for classpath
    jars = [os.path.join("lib", f) for f in os.listdir("lib") if f.endswith(".jar")]
    classpath = cp_sep.join(jars)
    run_classpath = cp_sep.join(["bin"] + jars)
    
    # Compile
    print("\nCompiling...")
    cmd_compile = ["javac", "-d", "bin", "-cp", classpath, "src/main/java/LoggingExample.java"]
    res = subprocess.run(cmd_compile)
    if res.returncode != 0:
        print("Compilation failed!")
        sys.exit(1)
    
    # Run
    print("\nRunning LoggingExample...")
    cmd_run = ["java", "-cp", run_classpath, "LoggingExample"]
    subprocess.run(cmd_run)

if __name__ == "__main__":
    setup()
    compile_and_run()
