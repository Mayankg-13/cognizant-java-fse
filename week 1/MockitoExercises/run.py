import os
import urllib.request
import subprocess
import sys

# Test dependencies
JARS = {
    "junit-platform-console-standalone-1.10.2.jar": "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar",
    "mockito-core-5.11.0.jar": "https://repo1.maven.org/maven2/org/mockito/mockito-core/5.11.0/mockito-core-5.11.0.jar",
    "byte-buddy-1.14.12.jar": "https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy/1.14.12/byte-buddy-1.14.12.jar",
    "byte-buddy-agent-1.14.12.jar": "https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy-agent/1.14.12/byte-buddy-agent-1.14.12.jar",
    "objenesis-3.3.jar": "https://repo1.maven.org/maven2/org/objenesis/objenesis/3.3/objenesis-3.3.jar"
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
    
    # Gather jar files
    jars = [os.path.join("lib", f) for f in os.listdir("lib") if f.endswith(".jar")]
    classpath = cp_sep.join(jars)
    run_classpath = cp_sep.join(["bin"] + jars)
    
    # Compile
    print("\nCompiling...")
    cmd_compile = [
        "javac", "-d", "bin", "-cp", classpath,
        "src/main/java/ExternalApi.java",
        "src/main/java/MyService.java",
        "src/test/java/MyServiceTest.java"
    ]
    res = subprocess.run(cmd_compile)
    if res.returncode != 0:
        print("Compilation failed!")
        sys.exit(1)
    
    # Run tests
    print("\nRunning Tests...")
    cmd_run = [
        "java", "-jar", "lib/junit-platform-console-standalone-1.10.2.jar",
        "--class-path", run_classpath,
        "--select-class", "MyServiceTest"
    ]
    subprocess.run(cmd_run)

if __name__ == "__main__":
    setup()
    compile_and_run()
