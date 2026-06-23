import os
import urllib.request
import subprocess
import sys

# JUnit 4 Jars
JARS = {
    "junit-4.13.2.jar": "https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar",
    "hamcrest-core-1.3.jar": "https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
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
    
    # Compile
    print("\nCompiling...")
    cmd_compile = ["javac", "-d", "bin", "-cp", "lib/*", 
                   "src/test/java/AssertionsTest.java"]
    res = subprocess.run(cmd_compile)
    if res.returncode != 0:
        print("Compilation failed!")
        sys.exit(1)
    
    # Run tests
    print("\nRunning Tests...")
    cmd_run = ["java", "-cp", "bin;lib/*", "org.junit.runner.JUnitCore", "AssertionsTest"]
    subprocess.run(cmd_run)

if __name__ == "__main__":
    setup()
    compile_and_run()
