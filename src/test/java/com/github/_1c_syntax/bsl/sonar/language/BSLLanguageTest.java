/*
 * This file is a part of SonarQube 1C (BSL) Community Plugin.
 *
 * Copyright (c) 2018-2022
 * Alexey Sosnoviy <labotamy@gmail.com>, Nikita Fedkin <nixel2007@gmail.com>
 *
 * SPDX-License-Identifier: LGPL-3.0-or-later
 *
 * SonarQube 1C (BSL) Community Plugin is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * SonarQube 1C (BSL) Community Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with SonarQube 1C (BSL) Community Plugin.
 */
package com.github._1c_syntax.bsl.sonar.language;

import com.github._1c_syntax.bsl.sonar.BSLCommunityProperties;
import org.junit.jupiter.api.Test;
import org.sonar.api.config.internal.MapSettings;

import static org.assertj.core.api.Assertions.assertThat;

class BSLLanguageTest {

  @Test
  void test_create() {

    var settings = new MapSettings();
    settings.setProperty(
      BSLCommunityProperties.BSL_FILE_EXTENSIONS_KEY,
      BSLCommunityProperties.BSL_FILE_EXTENSIONS_DEFAULT_VALUE);

    var language = new BSLLanguage(settings.asConfig());

    assertThat(language.getKey()).containsIgnoringCase("bsl");
    assertThat(language.getName()).containsIgnoringCase("1C (BSL)");
    assertThat(language.getFileSuffixes()).containsOnly(".bsl", ".os");

  }

}
