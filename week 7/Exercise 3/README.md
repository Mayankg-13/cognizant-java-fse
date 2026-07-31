# Exercise 3: Git Branching & Merging

## Objectives & Detailed Explanation

1. **Explain Branching & Merging Concepts**:
   - **Branching**: Branching allows developers to diverge from the main line of development (`master` or `main`) to work on new features, bug fixes, or experiments independently without destabilizing the working main codebase.
   - **Merging**: Merging takes the independent lines of development (commits from a feature branch) and integrates them back into the target trunk branch (`master` or `main`).

2. **Explain Branch Request in GitLab / Pull Request in GitHub**:
   - A **Branch Request** or **Pull Request (PR)** is a mechanism for notifying team members that a feature branch is ready to be reviewed and merged into the main line.
   - It allows team members to review code changes, run automated CI/CD checks, discuss potential improvements, and approve code before merging.

3. **Explain Merge Request in GitLab / PR Merge in GitHub**:
   - A **Merge Request (MR)** facilitates the formal code review and automated testing process.
   - Once approved by reviewers or repository maintainers, the Merge Request automatically merges the commits from the feature branch into the target branch (`master`/`main`) using strategies like Fast-Forward or Merge Commits.

4. **Construct Branch, Apply Changes, & Merge with Trunk**:
   - Practice hands-on creation of a feature branch (`GitNewBranch`), committing isolated changes, comparing diffs between branches, performing a branch merge into `master`, viewing commit log graphs, and safely deleting the feature branch after merging.

---


## Exercise Steps & Commands

### Task Requirement
Create a new branch named `GitNewBranch`, list all branches, switch to the new branch, add files and commit. Then switch back to `master`, inspect differences between `master` and `GitNewBranch`, merge `GitNewBranch` into `master`, observe commit logs using `git log --oneline --graph --decorate`, and finally delete the merged branch.

---

### Part A: Branching Steps

#### 1. Create a new branch `GitNewBranch`
```bash
git branch GitNewBranch
```

#### 2. List all local and remote branches available
List all branches and observe the `*` symbol indicating the currently active branch:
```bash
git branch -a
```
*Actual Execution Output:*
```text
  GitNewBranch
* master
```

#### 3. Switch to `GitNewBranch` and add files with content
```bash
git checkout GitNewBranch
echo "Feature branch content" > feature.txt
```
*Actual Execution Output:*
```text
Switched to branch 'GitNewBranch'
```

#### 4. Commit changes to the feature branch
```bash
git add feature.txt
git commit -m "Add feature.txt in GitNewBranch"
```
*Actual Execution Output:*
```text
[GitNewBranch 7ccab93] Add feature.txt in GitNewBranch
 1 file changed, 1 insertion(+)
 create mode 100644 feature.txt
```

#### 5. Verify branch status with `git status`
```bash
git status
```
*Actual Execution Output:*
```text
On branch GitNewBranch
nothing to commit, working tree clean
```

---

### Part B: Merging Steps

#### 1. Switch back to `master` branch
```bash
git checkout master
```
*Actual Execution Output:*
```text
Switched to branch 'master'
```

#### 2. List out command-line differences between `master` and `GitNewBranch`
```bash
git diff master..GitNewBranch
```
*Actual Execution Output:*
```text
diff --git a/feature.txt b/feature.txt
new file mode 100644
index 0000000..5824373
--- /dev/null
+++ b/feature.txt
@@ -0,0 +1 @@
+Feature branch content
```

#### 3. List out visual differences using diff tool (P4Merge / standard diff)
```bash
git difftool master GitNewBranch
```

#### 4. Merge `GitNewBranch` into `master` trunk
```bash
git merge GitNewBranch
```
*Actual Execution Output:*
```text
Updating f233603..7ccab93
Fast-forward
 feature.txt | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 feature.txt
```

#### 5. Observe commit log graph after merging
```bash
git log --oneline --graph --decorate
```
*Actual Execution Output:*
```text
* 7ccab93 (HEAD -> master, GitNewBranch) Add feature.txt in GitNewBranch
* f233603 Initial commit on master
```

#### 6. Delete branch after merging and check `git status`
```bash
git branch -d GitNewBranch
git status
```
*Actual Execution Output:*
```text
Deleted branch GitNewBranch (was 7ccab93).
On branch master
nothing to commit, working tree clean
```

---

## Summary of Essential Commands

| Command | Purpose |
| :--- | :--- |
| `git branch <branch-name>` | Creates a new branch |
| `git branch -a` | Lists all local and remote branches (`*` denotes active branch) |
| `git checkout <branch-name>` | Switches working directory to specified branch |
| `git checkout -b <branch-name>` | Shortcut to create and immediately switch to a new branch |
| `git diff branch1..branch2` | Compares code differences between two branches |
| `git merge <source-branch>` | Merges commits from source branch into currently active branch |
| `git log --oneline --graph --decorate` | Displays compact commit history as a visual graph |
| `git branch -d <branch-name>` | Safely deletes a merged branch |
