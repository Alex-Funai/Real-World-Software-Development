
<#
  .TITLE:
  DIR2SEV.PS1
  
  .DESCRIPTION:
  Sets (SEV)"system-environment-variables\path" for my java dks.

 .PREREQ:
  requires - powerShell-version-2.0||7.1.
  requires - admin console.
  requires - DACL && SACL access (for regedit).

.VARIABLE(S): ($newSevEntries, $currentSevEntries, $updatedSevEntries).
  @param $newSevEntries ::list of SDK directories to add to your SEV.
  @param $currentSevEntries ::the current live SEV in -name path.
  @param $updatedSevEntries ::the updated SEV

.INPUTS:
  SDK dirs from (bin/home)s.

.OUTPUTS:
  Updated SEV values in registry/system.

.CONTRIBUTE:
  Version:        1.0
  Author:         <Alexander Funai>
  Creation Date:  <4/3/2021>

.EXAMPLE:
  < Fucked up setting up dual boot, and had to convert drives to MBR, and then locked partitions like
    a noob. Had to reinstall. Made this incase it happens again.
#>

<# SCRIPT #>

<# [A.0 INTRODUCTION]:
#>  Write-Host "***********************************" 
    Write-Host "*       Welcome to DIR2SEV:       *"
    Write-Host "*                                 *"
    Write-Host "*  This program automates adding  *"
    Write-Host "*  SDK directories to my system   *"
    Write-Host "*  path environment variables     *"
               "***********************************"
    Write-Host "*  Press any key and let the the  *"
    Write-Host "*  secret tunnels will guide you  *"
    Write-Host "***********************************"
    $x = $host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")


<# [B. DECLARATION SKPENDENCE]: // Initialize storage variables for the SDK directories:
#>  $newSevEntries = 
    <# 1::jdk:: #> @(
    "D:\Engineering\Java\JDK8\bin;"+
    "D:\Engineering\Java\JDK15\bin;"+
    
        <# 1.5::jre #>
        "D:\Engineering\Java\JRE\9;"+
    
            <# 2 ::python #>
            "D:\Engineering\Python;"+
        
                <# 3:: gitBash #>
                "D:\Engineering\GIT\Git\bin;"+

                    <# 4:: curL #>
                    "D:\Engineering\Curl\usr\bin;"+

                        <# 5::gradle #>
                        "D:\Engineering\Gradle\gradle-6.8.3-bin\gradle-6.8.3\bin;"+

                            <# 6::node #>
                            "D:\Engineering\NodeJS\node_modules\npm\bin;"+

                                <# 7::groovy #>
                                "D:\Engineering\Groovy\groovy-3.0.7\bin;"+

                                    <# 8::maven #>
                                    "D:\Engineering\Maven\apache-maven-3.6.3\bin;"+

                                        <# 9::androidStudio #>
                                        "D:\Engineering\AndroidStudio\AndroidStudio\bin;")
                                        <# End list with .split(";") to separate entries. #>


    <#  [C.0 PROCESS]: // Initialize variable 4 current path-SEVs.
        HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Environment -Name Path
    #>  $currentSevEntries = [System.Environment]::GetEnvironmentVariable('Path','Machine')

        <#  [C.1 PROCESS]: // Initialize updated SEV by adding old and new entries.
        #>  $updatedSevEntries = @($currentSevEntries + $newSevEntries)
        
            <#  [C.2 PROCESS]: // Set the updated system-path entries:
            #>  [Environment]::SetEnvironmentVariable("Path", "$updatedSevEntries", "Machine")


                <#  [D.0 CONCLUSION]: Quick summary and farewell.
                #>  Write-Host "Success! Environment variables have been updated in the system-path registry/directory." 
                    $x = $host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")

                        Write-Host "****************************" 
                        Write-Host "*     Update complete:     *"
                        Write-Host "*                          *"
                        Write-Host "*     Item: 'System'       *"
                        Write-Host "*     Name: 'Path'         *"
                        Write-Host "*     Value: $updatedSev-  *"
                        Write-Host "*             Entries      *"
                        Write-Host "****************************"
                        Write-Host ""
                        Write-Host "****************************"
                        Write-HOst "*   Verify and test the    *"
                        Write-Host "*   set registry value     *"
                        Write-Host "*   by pressing any key..  *"
                        Write-Host "*                          *"
                        Write-Host "*   Or feel free to /cd 2  *"
                        Write-Host "* HKLM\SYSTEM\CurrentCont- *"
                        Write-Host "* rolSet\Control\Session-  *"
                        Write-Host "* Manager\Environment\Path *"
                        Write-Host "****************************"

                        <# Wait for user input to continue #>
                        $x = $host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
            
                            <#  [D.2 CONCLUSION]: Verify/print current registry entries: 
                            #>  $test = Get-ItemPropertyValue -Path "HKLM:\SYSTEM\CurrentControlSet\Control\Session Manager\Environment" -Name Path
                                $test

                                <#  [E.0]: Farewell
                                #>  Write-Host "****************************"

                                    Write-Host "*                          *" 
                                    Write-Host "*         Bye Bye          *"
                                    Write-Host "****************************"

                                    <# /SCRIPT #>
