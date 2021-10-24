package com.project.latitudetechnolabs.utils

import java.io.IOException

class ApiException(message: String) : IOException(message)
class NoIntenetConnection(message: String) : IOException(message)
