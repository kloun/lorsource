/*
 * Copyright 1998-2016 Linux.org.ru
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.org.linux.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.org.linux.util.bbcode.LorCodeService;

@Service
public class GroupInfoPrepareService {
  @Autowired
  private LorCodeService lorCodeService;

  public PreparedGroupInfo prepareGroupInfo(Group group, boolean secure) {
    String longInfo;

    if (group.getLongInfo()!=null) {
      longInfo = lorCodeService.parseComment(group.getLongInfo(), false);
    } else {
      longInfo = null;
    }

    return new PreparedGroupInfo(group, longInfo);
  }
}
