# Exercise 2: Implementing .gitignore to Ignore Unwanted Files and Folders

## Objectives & Detailed Explanation

1. **Understand `.gitignore` Concept & Purpose**:
   Learn how Git uses the `.gitignore` text file to exclude specific temporary, build-generated, or sensitive files from version control. This prevents unnecessary clutter in the repository and ensures only relevant source files are pushed to GitHub.

2. **Ignore Unwanted Files by Extension (`*.log`)**:
   Configure pattern matching rules in `.gitignore` using wildcards (such as `*.log`) to ensure all log files are automatically ignored regardless of where they are created in the project directory.

3. **Ignore Entire Folders & Directories (`log/`)**:
   Specify directory-level ignore rules (such as `log/`) to prevent an entire folder and all its contents from being tracked, staged, or committed by Git.

4. **Verify Untracked Status with `git status`**:
   Execute `git status` before and after creating `.gitignore` to confirm that specified files and folders are successfully filtered out of the untracked files list.

---

## Prerequisites
- Setting up Git environment.
- Integrated `notepad++` (or default text editor) with Git.
- Local Git repository and remote repository access on GitHub.

> **Note:** Please follow the steps for creating a free account in GitHub. Do not use Cognizant credentials to login to GitHub.

---

## Exercise Steps & Commands

### Task Requirement
Create a `.log` file and a `log` folder in the working directory of Git. Update the `.gitignore` file in such a way that on committing, these files (`.log` extensions and `log` folders) are ignored. Verify if the git status reflects the same about working directory, local repository, and remote git repository.

---

### Step 1: Create Log Files & Directory
Create sample log files and a log directory in your local Git repository:

```bash
# Create log files in working directory
echo "[INFO] Application started" > app.log
echo "[ERROR] Database connection failed" > error.log

# Create a log folder and log file inside it
mkdir log
echo "[DEBUG] Trace log output" > log/server.log

# Create a regular source file to track
echo "Sample Application Main File" > main.txt
```

---

### Step 2: Check Git Status Before `.gitignore`
Run `git status` to see untracked files before configuring `.gitignore`:

```bash
git status
```

**Actual Execution Output:**
```text
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	app.log
	error.log
	log/
	main.txt

nothing added to commit but untracked files present (use "git add" to track)
```

---

### Step 3: Create and Configure `.gitignore` File
Create a file named `.gitignore` in the root of your project repository and add rules to ignore `.log` files and the `log/` folder:

```bash
# Create .gitignore file
notepad++ .gitignore
```

**Contents of `.gitignore`:**
```gitignore
# Ignore all files with .log extension
*.log

# Ignore log directory and all files inside it
log/
```

---

### Step 4: Verify Git Status After `.gitignore`
Run `git status` again to verify that `.log` files and the `log/` directory are now ignored:

```bash
git status
```

**Actual Execution Output:**
```text
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	.gitignore
	main.txt

nothing added to commit but untracked files present (use "git add" to track)
```

> **Observation:** Notice that `app.log`, `error.log`, and the `log/` folder are no longer listed in Untracked files because Git is ignoring them according to the rules in `.gitignore`.

---

### Step 5: Stage and Commit Tracked Files
Stage and commit `.gitignore` and `main.txt`:

```bash
git add .
git commit -m "Initial commit: Add .gitignore to ignore log files and folders"
```

**Actual Execution Output:**
```text
[master (root-commit) f01760c] Initial commit: Add .gitignore and main.txt
 2 files changed, 6 insertions(+)
 create mode 100644 .gitignore
 create mode 100644 main.txt
```

Verify status after commit:
```bash
git status
```

**Actual Execution Output:**
```text
On branch master
nothing to commit, working tree clean
```

---

### Step 6: Push to Remote Repository
Push local changes to the remote repository on GitHub:

```bash
git push origin main
```

---

## Key Takeaways
1. `.gitignore` tells Git which files or directories to ignore and not track.
2. Wildcards like `*.log` ignore all files ending with `.log` anywhere in the repository.
3. Adding `/` after a folder name like `log/` ignores the entire folder and its contents.
4. Already committed files are not ignored retroactively unless removed from the index using `git rm --cached`.
