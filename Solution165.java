class Solution165 {
  public int compareVersion(String version1, String version2) {
    String[] v1Revisions = version1.split("\\.");
    String[] v2Revisions = version2.split("\\.");
    int totalRevisions = Math.max(v1Revisions.length, v2Revisions.length);

    for(int i=0; i<totalRevisions; i++){
      int v1Revision = (i > v1Revisions.length-1) ? 0:Integer.parseInt(v1Revisions[i]);
      int v2Revision = (i > v2Revisions.length-1) ? 0:Integer.parseInt(v2Revisions[i]);
      if(v1Revision < v2Revision){
        return -1;
      } else if(v1Revision > v2Revision){
        return 1;
      }
    }

    return 0;
  }
}